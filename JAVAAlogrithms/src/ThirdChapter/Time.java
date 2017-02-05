package ThirdChapter;

import java.util.Objects;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/5
 */
public class Time implements Comparable<Time> {
    private Integer hour;
    private Integer minute;
    private Integer second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }


    @Override
    public int compareTo(Time other) {
        if(!hour.equals(other.hour)){
            return hour.compareTo(other.hour);
        }else if(!minute.equals(other.minute)){
            return minute.compareTo(other.minute);
        }else{
            return second.compareTo(other.second);
        }
    }

    public boolean equals(Time obj) {
        return Objects.equals(hour, obj.hour) && Objects.equals(minute, obj.minute) && Objects.equals(second, obj.second);
    }
}
