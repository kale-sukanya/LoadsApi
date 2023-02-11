package com.api.LoadsApi.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name="Loads")
	public class LoadsEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long loadId;
		
		@Column(name = "Loading_Point")
		private String loadingPoint;
		
		@Column(name = "Unloading_Point")
		private String unloadingPoint;
		
		@Column(name = "Product_Type")
		private String productType;
		
		@Column(name = "Truck_Type")
		private String truckType;
		
		@Column(name = "No_Of_Trucks")
		private long noOfTruck;
		
		@Column(name = "Weight")
		private double weight;
		
		@Column(name = "Shipper_Id")
		private long shipperId;
		
		@Column(name = "Date")
		private Date Date;
		
	
		public LoadsEntity() {
			super();
		}
		
		public LoadsEntity(String loadingPoint, String unloadingPoint, String productType, String truckType,
			long noOfTruck, double weight, long shipperId, Date Date) {
			super();
			this.loadingPoint = loadingPoint;
			this.unloadingPoint = unloadingPoint;
			this.productType = productType;
			this.truckType = truckType;
			this.noOfTruck = noOfTruck;
			this.weight = weight;
			this.shipperId = shipperId;
			this.Date = Date;
	
		}
		
		public long getLoadId() {
			return loadId;
		}
		public void setLoadId(long loadId) {
			this.loadId = loadId;
		}
		public String getLoadingPoint() {
			return loadingPoint;
		}
		public void setLoadingPoint(String loadingPoint) {
			this.loadingPoint = loadingPoint;
		}
		public String getUnloadingPoint() {
			return unloadingPoint;
		}
		public void setUnloadingPoint(String unloadingPoint) {
			this.unloadingPoint = unloadingPoint;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		public String getTruckType() {
			return truckType;
		}
		public void setTruckType(String truckType) {
			this.truckType = truckType;
		}
		public long getNoOfTruck() {
			return noOfTruck;
		}
		public void setNoOfTruck(long noOfTruck) {
			this.noOfTruck = noOfTruck;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public long getShipperId() {
			return shipperId;
		}
		public void setShipperId(long shipperId) {
			this.shipperId = shipperId;
		}
		
		public Date getDate() {
			return Date;
		}
		public void setDate(Date date) {
			Date = date;
		}
	
		@Override
		public String toString() {
			return "LoadsModel [loadId=" + loadId + ", loadingPoint=" + loadingPoint + ", unloadingPoint="
					+ unloadingPoint + ", productType=" + productType + ", truckType=" + truckType + ", noOfTruck="
					+ noOfTruck + ", weight=" + weight + ", shipperId=" + shipperId + Date +"]";
		}
	}
