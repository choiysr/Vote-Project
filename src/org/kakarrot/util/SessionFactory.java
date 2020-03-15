package org.kakarrot.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum SessionFactory {
   
   FACTORY;

   private SqlSessionFactory factory;
   
   public SqlSession getSession() {
      return this.factory.openSession();
   }
   
   SessionFactory() {
      try(InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
      factory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }

}