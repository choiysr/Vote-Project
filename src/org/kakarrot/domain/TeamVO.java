package org.kakarrot.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class TeamVO {
	private String t_id, name, description, state, applier;
	private int max_mem;
	private List<MemberVO> members;
}
