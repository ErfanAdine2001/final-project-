package com.example.erfan_adine_p1_2.entity.user;

import com.example.erfan_adine_p1_2.entity.base.BaseUser;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MainUser extends BaseUser {
}
