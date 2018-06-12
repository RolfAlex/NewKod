package bot_x;

import java.io.InterruptedIOException;
import java.math.RoundingMode;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

import java.util.TimeZone;

public class Modules {

//Возвращает время сервера
    public String getDate(long unixSeconds) {
        Date date = new Date(unixSeconds * 1000L); // *1000 получаем миллисекунды 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss\ndd-MM-yyyy "); // какой формат нужен, выбераем 
        return sdf.format(date);
    }

//Возвращает баланс пользователя / баланс пользователя в ордерах 
    public static HashMap getUserBalansInfo(String key, String secret) {
        Exmo e = new Exmo(key, secret);
        HashMap<String, String> hash = new HashMap<String, String>();
        String result = e.Request("user_info", null);
        result = result.trim().replace("{", "");
        result = result.trim().replace("}", "");
        result = result.trim().replace("\"", "");
        result = result.trim().replace("es:", ",");
        result = result.trim().replace("ed:", ",");
        String[] balance = result.split("reserv");
        String[] balance1 = balance[0].split(",");
        String[] reserv = balance[1].split(",");
        String user_info_bal = "";
        for (int i = 2; i < balance1.length; i++) {
            String[] balanse_tmp = balance1[i].split(":");
            if (!balanse_tmp[balanse_tmp.length - 1].equalsIgnoreCase("0") && !balanse_tmp[balanse_tmp.length - 1].equalsIgnoreCase("balanc")) {
                String user_bal_info = balanse_tmp[0] + " " + balanse_tmp[balanse_tmp.length - 1];
                user_info_bal = user_info_bal.concat(user_bal_info).concat("\n");
            }
        }
        hash.put("balans", user_info_bal.trim().replace("\n\n", ""));
        String user_info_res = "";
        for (int i = 0; i < reserv.length; i++) {

            String[] reserv_tmp = reserv[i].split(":");
            if (!reserv_tmp[reserv_tmp.length - 1].equalsIgnoreCase("0")) {
                String user_res_info = reserv_tmp[0] + " " + reserv_tmp[reserv_tmp.length - 1];
                user_info_res = user_info_res.concat(user_res_info).concat("\n");
            }
        }
        hash.put("reserv", user_info_res.trim().replace("\n\n", ""));
        return hash;
    }

//Cтатистика цен и объемов торгов по валютным парам //Request fail: java.net.SocketTimeoutException: timeout
    public static HashMap getPrise(String key, String secret, String valent) {
        HashMap<String, String> data = new HashMap<String, String>();
        Exmo e = new Exmo(key, secret);
        String result = e.Request("ticker", null);
        result = result.trim().replace("{", "");
        result = result.trim().replace("\"", "");
        Stack<String> stackTmpVal = new Stack<>();
        Stack<String> stackTmpKey = new Stack<>();
        int t = 1;
        String[] a = result.split("},");
        for (int i = 0; i < a.length; i++) {
            if (a[i].indexOf(valent + ":") == 0) {
                String[] tmp = a[i].split(",");
                for (int j = 0; j < tmp.length; j++) {
                    String[] ar_data_tmp = tmp[j].split(":");
                    stackTmpVal.push(ar_data_tmp[ar_data_tmp.length - 1]);
                    stackTmpKey.push(Integer.toString(t));
                    t++;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            data.put(stackTmpKey.pop(), stackTmpVal.pop());
        }
        return data;
    }

/////////////////////////////////Ордера на торговлю
//pair - валютная пара
//quantity - кол-во по ордеру
//price - цена по ордеру
//type - тип ордера, может принимать следующие значения:
//buy - ордер на покупку
//sell - ордер на продажу
//market_buy - ордера на покупку по рынку
//market_sell - ордер на продажу по рынку
//market_buy_total - ордер на покупку по рынку на определенную сумму
//market_sell_total - ордер на продажу по рынку на определенную 
//Создание ордера на продажу *** coins по цене *** 
    public static String orderTypeCreated(String key, String secret, String pair, String quantity, String price, String type) {
        Exmo e = new Exmo(key, secret);
        String result = e.Request("order_create", new HashMap<String, String>() {
            {
                put("pair", pair);
                put("quantity", quantity);
                put("price", price);
                put("type", type);
            }
        });
        return result;
    }

//Отмена ордера по ID
    public static String orderIdCancel(String key, String secret, String order_id) {
        Exmo e = new Exmo(key, secret);
        String result = e.Request("order_cancel", new HashMap<String, String>() {
            {
                put("order_id", order_id);
            }
        });
        return result;
    }

//Подсчет в какую сумму обойдется покупка определенного кол-ва валюты по конкретной валютной паре
    public static HashMap getValentCount(String key, String secret, String pair, String quantity) {
        Exmo e = new Exmo(key, secret);
        HashMap<String, String> dataHash = new HashMap<>();
        String result = e.Request("required_amount", new HashMap<String, String>() {
            {
                put("pair", pair);
                put("quantity", quantity);
            }
        });
        result = result.trim().replace("{", "");
        result = result.trim().replace("}", "");
        result = result.trim().replace("\"", "");
        String[] ar_tmp = result.split(",");
        for (int i = 0; i < ar_tmp.length; i++) {
            String[] ar = ar_tmp[i].split(":");
            dataHash.put(ar[0], ar[1]);
        }
        return dataHash;
    }

    public  HashMap getOrderBook(String key, String secret, String pair, String limit) {
        Exmo e = new Exmo(key, secret);
        String result = e.Request("order_book", new HashMap<String, String>() {
            {
                put("pair", pair);
                put("limit", limit);
            }
        });
        HashMap<String, String> statCup = new HashMap<>(); // Возвращает значения согласно ключа (ask_quantity, ask_top...)
        Stack<String> stHashKey = new Stack<>();
        Stack<String> stHashVal = new Stack<>();
        result = result.replaceAll("ETH_USD", "").replaceAll("\"", "").replaceAll("}", "").replaceAll("]", "").replaceAll("\\{", "").replaceAll("ask:\\[", "rIm ask:").replaceAll("bid:\\[", "rIm bid:").replaceAll(":ask_quantity", "ask_quantity");
//        System.out.println(result);
        String[] rim = result.split("rIm");
        String[] rimStats = rim[0].split(",");
        for (int i = 0; i < rimStats.length; i++) {
            String[] rimS = rimStats[i].split(":");
            stHashKey.push(rimS[0]);
            stHashVal.push(rimS[1]);
        }
        for (int i = 0; i < rimStats.length; i++) {
            statCup.put(stHashKey.pop(), stHashVal.pop());
        }
        String ask = rim[1].replaceAll("ask:\\[", "");
        String bid = rim[2].replaceAll("bid:\\[", "");
        statCup.put("ask", ask);
        statCup.put("bid", bid);
        return statCup;
    }

     public static double getFormatPrise(double prise) {
        String p = new DecimalFormat("#0.00").format(prise).replace(",", ".");
        double formPrise = Double.parseDouble(p);
        return formPrise;
    }
     
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            String key = "K-91fcc80c5c4263e7c61635629a3c42eaf331ce88";
            String secret = "S-8b1012889c95bb34db05cf85889f3086c21108f0";
            String valent = "ETH_USD";
//            System.out.println(getPrise(key, secret, valent).get("1"));
//            Thread.sleep(0);
// System.out.println(getPrise(key, secret, valent).get("2"));
// System.out.println(getPrise(key, secret, valent).get("3"));
// System.out.println(getPrise(key, secret, valent).get("4"));
// System.out.println(getPrise(key, secret, valent).get("5"));
// System.out.println(getPrise(key, secret, valent).get("6"));
// System.out.println(getPrise(key, secret, valent).get("7"));
            System.out.println(getUserBalansInfo(key, secret).get("balans"));
// System.out.println(getUserBalansInfo(key, secret).get("reserv"));

            Exmo e = new Exmo(key, secret);
            HashMap<String, String> dataHash = new HashMap<>();

// String kurs = (String) getPrise(key, secret, valent).get("1");
// double sumCoins = Double.parseDouble(summ) / Double.parseDouble(kurs);
// double commision = sumCoins * 0.2 / Double.parseDouble(summ);
// sumCoins = sumCoins - commision - 0.00042027;
// System.out.println(getValentCount(key, secret, "ETH_USD", "0.03").get("quantity"));
// System.out.println(getValentCount(key, secret, "ETH_USD", "0.03").get("amount"));
// System.out.println(getValentCount(key, secret, "ETH_USD", "0.03").get("avg_price"));
        }

//System.out.println(Double.parseDouble(summ ));
//System.out.println(Double.parseDouble("514.99"));
//System.out.println(sumCoins);
//DecimalFormat df = new DecimalFormat("#.#######");
//df.setRoundingMode(RoundingMode.CEILING);
// System.out.println(df.format(sumCoins));
    }
}
