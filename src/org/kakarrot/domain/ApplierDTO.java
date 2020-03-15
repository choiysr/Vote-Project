package org.kakarrot.domain;

import lombok.Data;

@Data
public class ApplierDTO {
	private MemberVO member_vo;
	private TeamVO team_vo;
	private String decision;
}
