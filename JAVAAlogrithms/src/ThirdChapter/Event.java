package ThirdChapter;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/2/5
 */
public class Event {
    private String event;

    public Event(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public boolean equals(Event obj) {
        return event.equals(obj.event);
    }
}
