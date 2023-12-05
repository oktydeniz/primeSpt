package com.facility.primeSport.entitiy.analytics;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_daily_analytics")
public class UserDailyData extends DailyBaseModel {

}
