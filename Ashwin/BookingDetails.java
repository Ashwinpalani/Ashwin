package com.Ashwin;

import java.text.NumberFormat;

public class BookingDetails {
	private double sourceLatitude;
	private double sourceLongitude;
	private double destinationLatitude;
	private double destinationLongitude;
	private double rate = 30;
	private double rideFare;
	private double distance;
	
	
	public BookingDetails() {
		
	}

    public BookingDetails(Double sourceLatitude, Double sourceLongitude,Double destinationLatitude,Double destinationLongitude)
    {
        this.sourceLatitude = sourceLatitude;
        this.sourceLongitude = sourceLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }
	
	public double getSourcelatitude() {
		return sourceLatitude;
	}
	public double getSourcelongitude() {
		return sourceLongitude;
	}
	public double getDestinationlatitude() {
		return destinationLatitude;
	}
	public double getDestinationlongitude() {
		return destinationLongitude;
	}
	
	public double distancekm(BookingDetails b)
	{
		 NumberFormat nf = NumberFormat.getInstance();
	        nf.setMaximumFractionDigits(2);
		 this.distance =Double.parseDouble(nf.format( Math.sqrt(Math.pow(b.destinationLatitude - b.sourceLatitude, 2) + 
	                Math.pow(b.destinationLongitude - b.sourceLongitude, 2))));
		 return distance;
	}
	

	public double travelCost(double travelDistances)
    {
		BookingDetails b= new BookingDetails();
		NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        this.rideFare = Double.parseDouble(nf.format((travelDistances/10) * rate));
       
        return rideFare;
    }
	
	public String updateQuery() {
		return "'"+sourceLatitude+"','"+sourceLongitude+"','"+destinationLatitude+"','"+destinationLongitude+"','"+distance+"";
}
	
	
	

	

}
