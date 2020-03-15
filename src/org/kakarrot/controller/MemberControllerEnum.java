package org.kakarrot.controller;

public enum MemberControllerEnum {
//   /member/login.sr		path  type
	LOGIN {
		public void get() {
			System.out.println("1번 테스트");
		}
		
		public void post() {
			System.out.println("1번 테스트");
		}
	},
	
	LOGOUT {
		public void get() {
			System.out.println("2번 테스트");
		}
	};
	
	public void get() {}
	
	public void post() {}
}
