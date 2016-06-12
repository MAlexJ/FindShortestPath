package com.alex.entity.vo;

/**
 * Created by malex on 12.06.16.
 */
public class SearchByCities {

   private String source;
   private String destination;

    public SearchByCities() {
    }

    public SearchByCities(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchByCities that = (SearchByCities) o;

        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        return destination != null ? destination.equals(that.destination) : that.destination == null;

    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchByCities{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
