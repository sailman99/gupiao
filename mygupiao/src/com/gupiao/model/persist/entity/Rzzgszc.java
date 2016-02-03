package com.gupiao.model.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Rzzgszc {

		
		private String gupiaodaima;
		private Date riqi;
		private Double rzzgzc;
		private Double ltgb;
		private Double longtime;
		private Double  sendemail;
		private Date emailriqi;
	

		@Id
		public String getGupiaodaima() {
			return gupiaodaima;
		}
		public void setGupiaodaima(String gupiaodaima) {
			this.gupiaodaima = gupiaodaima;
		}
		public Date getRiqi() {
			return riqi;
		}
		public void setRiqi(Date riqi) {
			this.riqi = riqi;
		}
		public Double getRzzgzc() {
			return rzzgzc;
		}
		public void setRzzgzc(Double rzzgzc) {
			this.rzzgzc = rzzgzc;
		}
		public Double getLtgb() {
			return ltgb;
		}
		public void setLtgb(Double ltgb) {
			this.ltgb = ltgb;
		}
		public Double getLongtime() {
			return longtime;
		}
		public void setLongtime(Double longtime) {
			this.longtime = longtime;
		}
		public Double getSendemail() {
			return sendemail;
		}
		public void setSendemail(Double sendemail) {
			this.sendemail = sendemail;
		}
		public Date getEmailriqi() {
			return emailriqi;
		}
		public void setEmailriqi(Date emailriqi) {
			this.emailriqi = emailriqi;
		}
		
	
}
