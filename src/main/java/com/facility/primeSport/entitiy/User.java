package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.dto.user.UserAuthRegisterRequest;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.facility.primeSport.enums.Gender;
import com.facility.primeSport.enums.permission.Role;
import com.facility.primeSport.util.CommonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends DateIDBaseModel {

        @Serial
        private static final long serialVersionUID = 1697222697222020020L;

        @Column(name = "user_name")
        @JsonView(View.Public.class)
        private String userName;

        @Column(name = "email", unique = true, nullable = false)
        @JsonView(View.Public.class)
        private String email;

        @Column(name = "password")
        @JsonView(View.Private.class)
        @JsonIgnore
        private String password;

        @JsonView(View.Public.class)
        @Column(name = "phone_number")
        private String phoneNumber;

        @JsonView(View.Public.class)
        @Enumerated(EnumType.STRING)
        @Column(name = "gender")
        private Gender gender;

        @JsonView(View.Public.class)
        @Column(name = "is_enable")
        private boolean isEnable;

        @JsonView(View.Public.class)
        @Column(name = "is_deleted")
        private boolean isDeleted;

        @JsonView(View.Public.class)
        @Column(name = "is_admin")
        private boolean isAdmin;

        @JsonView(View.Public.class)
        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        private Role role;

        @Column(name = "verification_code")
        @JsonView(View.Private.class)
        private String verificationCode;

        @Column(name = "birth_date")
        @JsonView(View.Public.class)
        private LocalDate birthDate;

        @Column(name = "user_level")
        @JsonView(View.Public.class)
        private String userLevel;

        @Column(name = "avatar_url")
        @JsonView(View.Public.class)
        private String avatarUrl;

        @Column(name = "language")
        @JsonView(View.Public.class)
        private String language;

        @Column(name = "is_marketing_active")
        @JsonView(View.Public.class)
        private Boolean isActiveMarketing;

        @Column(name = "is_analytics_active")
        @JsonView(View.Public.class)
        private Boolean isActiveAnalytics;

        @Column(name = "is_adverting_active")
        @JsonView(View.Public.class)
        private Boolean isActiveAdverting;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "coach_id")
        @JsonView(View.Internal.class)
        private User coach;

        @Column(name = "member_start_date")
        @JsonView(View.Public.class)
        private LocalDate memberStartDate;

        @Column(name = "member_end_date")
        @JsonView(View.Public.class)
        private LocalDate memberEndDate;


        public User(UserAuthRegisterRequest request){
                this.userName = request.getUserName();
                this.email = request.getEmail();
                this.role = Role.USER;
                this.isActiveAdverting = request.getIsActiveAdverting();
                this.isActiveAnalytics = request.getIsActiveAnalytics();
                this.isActiveMarketing = request.getIsActiveMarketing();
                this.phoneNumber = request.getPhoneNumber();
                this.birthDate = request.getBirthDate();
                this.gender = request.getGender();
                this.isEnable = false;
                this.userLevel = "A:1";
                this.verificationCode = CommonUtil.createVerificationCode();
        }

        @ManyToMany(mappedBy = "users")
        @JsonIgnore
        private Set<Building> buildings = new HashSet<>();

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User other)) {
                return false;
            }
            return Objects.equals(getId(), other.getId());
        }


}
