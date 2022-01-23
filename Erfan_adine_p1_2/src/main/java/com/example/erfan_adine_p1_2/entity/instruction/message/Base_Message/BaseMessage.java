package com.example.erfan_adine_p1_2.entity.instruction.message.Base_Message;

import com.example.erfan_adine_p1_2.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseMessage extends BaseEntity {


}
