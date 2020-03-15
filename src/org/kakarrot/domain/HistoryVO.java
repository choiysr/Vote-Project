package org.kakarrot.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HistoryVO {
	private String id, t_name, target;
	private Date create_date;
	private List<HistoryMemberVO> members;
}
