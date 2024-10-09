package org.example.HW1.Clock;

public class Clock implements Readable{
    private int hours;
    private int minutes;
    private int seconds;

    public void setHours(int hours){
        this.hours = (hours % 24 + 24) % 24;
    }
    public int getHours(){
        return this.hours;
    }
    public void setMinutes(int minutes){
        this.minutes = (minutes % 60 + 60) % 60;
    }
    public int getMinutes(){
        return this.minutes;
    }
    public void setSeconds(int seconds){
        this.seconds = (seconds % 60 + 60) % 60;
    }
    public int getSeconds(){
        return this.seconds;
    }
    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0; // Сброс часов после 24
                }
            }
        }
    }

    @Override
    public void readTime() {
        System.out.printf("Текущее время: %02d:%02d:%02d%n", hours, minutes, seconds);
    }
}
