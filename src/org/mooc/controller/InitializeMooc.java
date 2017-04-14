package org.mooc.controller;

import org.mooc.processing.courses.CrawlCourses;
import org.mooc.processing.logs.GenUserLearnedCourses;
import org.mooc.processing.logs.ProcessLogs;
import org.mooc.processing.users.CrawlUsers;
import org.mooc.recommend.frequentPattern.GenAprioriDataset;
import org.mooc.recommend.frequentPattern.GenFrequentCourses;
import org.mooc.recommend.frequentPattern.GenFrequentRec;

/**
* @author : wuke
* @date : 2017��4��11������4:27:16
* Title : MoocInit
* Description : Initialize the Web Service.
*/
public class InitializeMooc {
	/**
	 * Initialization of the whole service
	 */
	public static void main() {
		InitializeMooc.initMooc();
	}
	
	public static void initMooc() {
		
		// CrawlUsers.crawlUsers(); // Not use yet.
		// System.out.println("******************** �û���Ϣ��ȡ�ɹ���********************");
		
		CrawlCourses.crawlCourses();
		System.out.println("******************** �γ���Ϣ��ȡ�ɹ���********************");
		
		ProcessLogs.initProcessLogs();
		System.out.println("******************** ��־��Ϣ��ȡ�ɹ���********************");
		
		GenUserLearnedCourses.initGenUserLearnedCourses();
		System.out.println("******************** �û���ѧ�γ����ɳɹ���********************");
			
		GenAprioriDataset.generateRecords();
		GenFrequentCourses.genFrequentCourses();
		System.out.println("******************** �γ�Ƶ��������ɳɹ���********************");
		
		GenFrequentRec.generateFrequentRec();
		System.out.println("******************** �û��Ƽ�������ɳɹ���********************");	
	}
}