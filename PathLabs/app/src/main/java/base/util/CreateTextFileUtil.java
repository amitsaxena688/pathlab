package base.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by fos on 11/5/2015.
 */
public class CreateTextFileUtil {


    // write text to file
    public void WriteFile(String response, String fname, Context mContext) {

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        String NextLine= "\n\n=====================================\n\n";

        response = currentDateTimeString + response+NextLine;
        try {

            File externalFile = mContext.getExternalFilesDir("Session Data");


            File file = new File(externalFile, fname + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file,true);
            writer.append(response);
            writer.flush();
            writer.close();
            Log.e("Suceess", "'file Write");
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


}




