package com.example.erfan_adine_p1_2.entity.instruction.message.suggestion;

import com.example.erfan_adine_p1_2.entity.base.BaseEntity;
import com.example.erfan_adine_p1_2.entity.instruction.message.Base_Message.BaseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionEmployee extends BaseMessage {
}
