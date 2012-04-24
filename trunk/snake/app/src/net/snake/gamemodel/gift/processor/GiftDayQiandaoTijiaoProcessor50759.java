package net.snake.gamemodel.gift.processor;

import net.snake.ann.MsgCodeAnn;
import net.snake.gamemodel.common.processor.CharacterMsgProcessor;
import net.snake.gamemodel.common.response.PrompMsg;
import net.snake.gamemodel.common.response.TipMsg;
import net.snake.gamemodel.hero.bean.Hero;
import net.snake.netio.message.RequestMsg;
import net.snake.shell.Options;


/**
 * 50759 请求领取升级礼包
 * 
 * 
 */
@MsgCodeAnn(msgcode = 50759,accessLimit=200)
public class GiftDayQiandaoTijiaoProcessor50759 extends CharacterMsgProcessor {

	@Override
	public void process(Hero character, RequestMsg request)
			throws Exception {
		if(Options.IsCrossServ){
			character.sendMsg(new PrompMsg(TipMsg.MSGPOSITION_ERRORTIP,1306));
			return;
		}
		character.getMyCharacterGiftpacksManger().getRoleDayQiandaoGiftPacksManager().qiandao();
	}

}
