package org.mooc.main;

import org.mooc.processing.courses.CrawlerGetCoursesStoreMongodb;
import org.mooc.processing.logs.ProcesssLogsJsonFileStoreMongodb;
import org.mooc.processing.users.CrawlerGetUsersStoreMongodb;
import org.mooc.recommend.frequentPattern.GenerateAprioriDataset;
import org.mooc.recommend.frequentPattern.GenerateFrequentCourses;
import org.mooc.recommend.frequentPattern.GenerateFrequentRec;
import org.mooc.recommend.frequentPattern.GenerateUserLearnedCourses;

/**
* @author : wuke
* @date   : 2016��12��26������6:38:33
* Title   : Main
* Description : 
*/
public class Main {	
	public static void main(String[] args) {
		Main.first(args);
	}
	
	static void first(String[] args) {
		// ���ݻ�ȡ
		CrawlerGetUsersStoreMongodb.main(args);      // ��ȡ�û�,����MongoDB
		System.out.println("******************************�û���Ϣ��ȡ�ɹ���******************************");
		CrawlerGetCoursesStoreMongodb.main(args);    // ��ȡ�γ�,����MongoDB
		System.out.println("******************************�γ���Ϣ��ȡ�ɹ���******************************");
		ProcesssLogsJsonFileStoreMongodb.main(args); // ��ȡ��־,����MongoDB,��Ҫ��org.mooc.processing.logs.ProcesssLogsJsonFileStoreMongodb���޸���־�ļ�·��
		System.out.println("******************************��־��Ϣ��ȡ�ɹ���******************************");
		
		// Ƶ����Ƽ�
		GenerateUserLearnedCourses.main(args); // user_learned_courses
		System.out.println("***************************�û���ѧ�γ����ɳɹ���***************************");
		GenerateAprioriDataset.main(args);     // process the user_learned_courses records into the form that fit the method MyApriori
		GenerateFrequentCourses.main(args);    // call MyApriori(), generate frequent pattern courses
		System.out.println("*************************�γ�Ƶ������ɳɹ���*************************");
		GenerateFrequentRec.main(args);        // generate frequent recommendations for every user
		System.out.println("**************************Ϊÿ���û������Ƽ�����ɹ���**************************");		
	}
}