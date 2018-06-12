/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot_x;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Test_test {

    public static Double getOrderAskPrise(double persProfit, double trustedLimit ) {
        String key = "K-91fcc80c5c4263e7c61635629a3c42eaf331ce88";
        String secret = "S-8b1012889c95bb34db05cf85889f3086c21108f0";
        String pair = "ETH_USD";
        String limit = "10";
        Modules mod = new Modules();
        double sumOrderAskPrise = 0.0;
        String[] ask_ar = mod.getOrderBook(key, secret, pair, limit).get("ask").toString().split(",\\[");
        for (int i = 0; i < ask_ar.length; i++) {
            String[] ar_1 = ask_ar[i].split(",");
            sumOrderAskPrise += Double.parseDouble(ar_1[0]);
        }
        double averagePrise = sumOrderAskPrise / Double.parseDouble(limit);
        System.out.println(averagePrise);
        double prsPrfSal = trustedLimit * persProfit / 100;
        System.out.println(prsPrfSal);
        double orderPrise = (averagePrise   + prsPrfSal) * 1.004;
        return orderPrise;
    }

    public static Double getOrderBidPrise(double persProfit) throws InterruptedException, SocketTimeoutException {
        double r = 0.0;
        String key = "K-91fcc80c5c4263e7c61635629a3c42eaf331ce88";
        String secret = "S-8b1012889c95bb34db05cf85889f3086c21108f0";
        String pair = "ETH_USD";
        Modules mod = new Modules();
        //Вычисление средней цены на << ПОКУПКУ >> ******************************
        String bid_ar = mod.getPrise(key, secret, pair).get("1").toString();
        double prsPrfSal = Double.parseDouble(bid_ar) * persProfit / 100;
        double orderPrise = (Double.parseDouble(bid_ar) - prsPrfSal) / 1.004;
        r = orderPrise;
        return r;

    }

    public static double getFormatPrise(double prise) {
        String p = new DecimalFormat("#0.00").format(prise).replace(",", ".");
        double formPrise = Double.parseDouble(p);
        return formPrise;
    }

    public static void main(String[] args) throws InterruptedIOException, InterruptedException {
        String key = "K-91fcc80c5c4263e7c61635629a3c42eaf331ce88";
        String secret = "S-8b1012889c95bb34db05cf85889f3086c21108f0";
        String pair = "ETH_USD";
        Modules mod = new Modules();

        double balans_eth = 0.04395201;
        double balans_usd = 26.5;
        double salary = 0.5;
        double orderAsk = getFormatPrise(getOrderAskPrise(salary, balans_usd));
        double orderBid = getFormatPrise(getOrderBidPrise(salary));

        double prise = 0.0;
        int lifeTime = 0;
        int orderLife = 3600;
        boolean check = false;
        if (check == false) {
            System.out.println("Цена ордера на продажу " + orderAsk);
        } else {
            System.out.println("Цена ордера на покупку " + orderBid);
        }
        while (true) {

            prise = getFormatPrise(Double.parseDouble(mod.getPrise(key, secret, pair).get("1").toString()));

            Thread.sleep(500);
            System.out.println(prise);
            //ПРОДАЖА
            if (orderAsk <= prise && check == false) {
                System.out.println("Цена ордера на продажу " + orderAsk);
                System.out.println("Продано по цене " + prise);
                orderBid = getOrderBidPrise(salary);
                System.out.println("Цена ордера на покупку " + orderBid);
                check = true;
            }
            //ПОКУПКА
            if (orderBid >= prise && check == true) {
                System.out.println("Цена ордера на покупку " + orderBid);
                System.out.println("---Куплено по цене " + prise);
                orderAsk = getOrderAskPrise(salary, balans_usd);
                System.out.println("Цена ордера на продажу " + orderAsk);
                check = false;
            }
            //ЖИЗНЬ ОРДЕРА
            if (lifeTime > orderLife && check == true) {
                orderBid = getOrderBidPrise(salary);
                System.out.println("смена ордера на продажу " + orderBid);
                lifeTime = 0;
            } else if (lifeTime > orderLife && check == false) {
                orderAsk = getOrderAskPrise(salary, balans_usd);
                System.out.println("смена ордера на покупку " + orderAsk);
                lifeTime = 0;
            }
            lifeTime++;
        }
    }
}
