/**
 * 
 */
package net.snake.gamemodel.wedding.processor;

import net.snake.ann.MsgCodeAnn;
import net.snake.gamemodel.common.processor.CharacterMsgProcessor;
import net.snake.gamemodel.common.response.PrompMsg;
import net.snake.gamemodel.common.response.TipMsg;
import net.snake.gamemodel.hero.bean.Hero;
import net.snake.netio.message.RequestMsg;
import net.snake.shell.Options;


/**
 * 删除耳语
 */

@MsgCodeAnn(msgcode = 52235)

public class WeddingSpeakDeletePrcocessor52235 extends CharacterMsgProcessor {

	/* (non-Javadoc)
	 * @see net.snake.commons.msgprocess.CharacterMsgProcessor#process(net.snake.bean.character.Character, net.snake.commons.message.RequestMsg)
	 */
	@Override
	public void process(Hero character, RequestMsg request)
			throws Exception {
		if(Options.IsCrossServ){
			character.sendMsg(new PrompMsg(TipMsg.MSGPOSITION_ERRORTIP,1306));
			return;
		}
		int id = request.getInt();
		if(!character.getMyFriendManager().getRoleWedingManager().isWedding()){
			return;
		}
		character.getMyFriendManager().getRoleCouplesSpeakManager().deleteCouplesSpeak(id);
	}

}
