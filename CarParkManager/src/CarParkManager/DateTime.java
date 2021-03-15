package CarParkManager;

import java.util.Objects;

public class DateTime implements Comparable<DateTime> {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;

    public DateTime(int day, int month, int year, int hour, int minutes) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return day == dateTime.day &&
                month == dateTime.month &&
                year == dateTime.year &&
                hour == dateTime.hour &&
                minutes == dateTime.minutes;
    }

    private int toMinutes() {
        return this.year * 365 * 24 * 60 + this.month * 30 * 24 * 60 + this.day * 24 * 60 + this.hour * 60;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, hour, minutes);
    }

    @Override
    public int compareTo(DateTime o) {
        return this.toMinutes() - o.toMinutes();
    }
}