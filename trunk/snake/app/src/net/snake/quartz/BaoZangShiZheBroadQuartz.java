package net.snake.quartz;

import net.snake.GameServer;
import net.snake.gamemodel.common.response.PrompMsg;
import net.snake.gamemodel.common.response.TipMsg;
import net.snake.gamemodel.hero.bean.Hero;
import net.snake.serverenv.vline.CharacterRun;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * 寻宝鼠定时任务 Copyright (c) 2011 Kingnet
 * 
 * @author serv_dev
 */
public class BaoZangShiZheBroadQuartz implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		GameServer.vlineServerManager.runToOnlineCharacter(new CharacterRun() {
			@Override
			public void run(Hero character) {
				character.sendMsg(new PrompMsg(TipMsg.MSGPOSITION_SYSBROADCAST, 20124));
			}
		});
	}
}
