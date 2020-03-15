package org.kakarrot.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectVO {
	private String id, name;
	private Date create_date;
	private List<String> teamNames;	//세션 내부에 팀 name들
}
