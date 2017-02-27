package helper;

import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by ghane on 2/14/2017.
 */

public class utile {

    public static void showSnack(View root, String msg, String actionMsg, View.OnClickListener actionClick) {
        Snackbar snak = Snackbar.make(root,
                msg,
                Snackbar.LENGTH_INDEFINITE)
                .setAction(actionMsg, actionClick);
        TextView tv = (TextView) (snak.getView()).findViewById(android.support.design.R.id.snackbar_text);
        tv.setTypeface(Typeface.DEFAULT);
        snak.show();
    }

    public static String getFormattedPrice(String price) {
        double p = Double.parseDouble(price);
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
        return formatter.format(p);
    }

    public static String getFormattedPrice(int price) {
        double p =price;
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
        return formatter.format(p);
    }
}
