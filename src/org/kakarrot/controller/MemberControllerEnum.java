package org.kakarrot.controller;

public enum MemberControllerEnum {
//   /member/login.sr		path  type
	LOGIN {
		public void get() {
			System.out.println("1�� �׽�Ʈ");
		}
		
		public void post() {
			System.out.println("1�� �׽�Ʈ");
		}
	},
	
	LOGOUT {
		public void get() {
			System.out.println("2�� �׽�Ʈ");
		}
	};
	
	public void get() {}
	
	public void post() {}
}
