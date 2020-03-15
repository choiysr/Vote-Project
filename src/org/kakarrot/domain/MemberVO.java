package org.kakarrot.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class MemberVO {
	private String m_id, pw, name, picture, admin, auth;
	private Date reg_date;
	private boolean waiting;
	// teamMemberVO => t_id, m_id, auth 
	
	public MemberVO() {
		this.waiting = true;
	}
}
