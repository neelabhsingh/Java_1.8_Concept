package callback.demo2;

import java.util.ArrayList;
import java.util.List;

interface TimeUpdateCallBack{
    void updateTime(long time);
}
class WebsiteTimeUpdateCallBack implements TimeUpdateCallBack{
    @Override
    public void updateTime(long time) {
        //print the updated time anywhere in your website's example.
        System.out.println(time);
    }
}

class SystemTimer{
    List<TimeUpdateCallBack> callBacks = new ArrayList<>();
    public void registerCallBackForUpdatesEveryHours(TimeUpdateCallBack timeUpdateCallBack){
        callBacks.add(timeUpdateCallBack);
    }
    /*
    *  This SystemTimer may have more logic here we don't know..
    * At some point of the implementation of this SystemTimer,
    * this method will be called abd every registered timeCallback will be called
    * Every registered timeCallBack may have a totally
    * different implementation of the method updateTime() and my be used
    * in different ways by different clients.
     */
    public void oneHourHasBeenExpired(){
        for (TimeUpdateCallBack timeUpdateCallBack : callBacks){
            timeUpdateCallBack.updateTime(System.currentTimeMillis());
        }
    }
}

//This is our client. It will be used in our website example. It shall update
//update the website's time every hours.
public class WebSiteTimeUpdater {
    public static void main(String[] args) {
        SystemTimer systemTimer = new SystemTimer();
        TimeUpdateCallBack webSiteCallBackUpdater = new WebsiteTimeUpdateCallBack();
        systemTimer.registerCallBackForUpdatesEveryHours(webSiteCallBackUpdater);
    }
}
//Ref: http://cleancodedevelopment-qualityseal.blogspot.com/2012/10/understanding-callbacks-with-java.html