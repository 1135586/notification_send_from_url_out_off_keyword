import java.io.BufferedReader;
import java.net.URL;
import java.io.InputStreamReader;

public class App{


    //REQUIRED STRINGS BLOCK
    //NEED TO BE POPULATED !!!

    static String http_url = "";
    static String keyword = "";
    static String success_notification_message = "ONLINE";
    static String fails_notification_message = "OFFLINE";

    //REQUIRED STRINGS ENDBLOCK
    //this dones because cronjob fails with args sometimes

  public static void main(String[] args) throws Exception{

    //processing code below
    //that uses CONTAINS method of String object

    String html = "";
    String line = "";
    URL url = null;
    BufferedReader in = null;

    try{
        url = new URL(http_url);
        in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((line = in.readLine())!= null){
            html += line;
        }
    } finally {
          if (in != null) in.close();
    }

    // FIND KEYWORD WITHIN HTML

    if (html.toLowerCase().contains(keyword)){
        notify(success_notification_message);
    } else {
        notify(fails_notification_message);
    }
  }

  static void notify(String message) throws Exception{
        System.out.println(message);
        String[] cmd = {"/usr/bin/notify-send",
                   "-t",
                   "10000",
                   message};
        Runtime.getRuntime().exec(cmd);
  }
}
