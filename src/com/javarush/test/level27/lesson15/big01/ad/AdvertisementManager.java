package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nakoryakov on 06.12.15.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
        List<Advertisement> listVideos = advertisementStorage.list();
        if (listVideos.isEmpty()){
            throw new NoVideoAvailableException();
        }
        Collections.sort(listVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0) return -result;

                long firstAdvertisementCostPerSecond = ((o1.getAmountPerOneDisplaying() * 1000) / o1.getDuration());
                long secondAdvertisementCostPerSecond = ((o2.getAmountPerOneDisplaying() * 1000) / o2.getDuration());

                return Long.compare(firstAdvertisementCostPerSecond, secondAdvertisementCostPerSecond);
            }
        });

        for (Advertisement ad: listVideos){
            if (ad.getDuration() <= timeSeconds){
                ConsoleHelper.writeMessage(String.format(("%s is displaying... %d, %d"), ad.getName(),
                            ad.getAmountPerOneDisplaying(), (ad.getAmountPerOneDisplaying()*1000) / ad.getDuration()));
                timeSeconds -= ad.getDuration();
                ad.revalidate();
            }
        }
    }
}
