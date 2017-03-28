package com.liferay.micro.maintainance.util;

import com.liferay.micro.maintainance.exception.NoSuchVoteValueException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class VotesJSONSerializer {

	public static String createVotes() {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(VoteConstants.NO_DESCRIPTION, 0);
		jsonObject.put(VoteConstants.NOT_VOTED_DESCRIPTION, 0);
		jsonObject.put(VoteConstants.YES_DESCRIPTION, 0);

		return jsonObject.toString();
	}

	public static String updateVotes(
			String analysisData, int previousVote, int vote)
		throws JSONException, NoSuchVoteValueException {

		_validateVote(previousVote);
		_validateVote(vote);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(analysisData);

		if (previousVote == VoteConstants.NO) {
			_decreaseVote(jsonObject, VoteConstants.NO_DESCRIPTION);
		}
		else if (previousVote == VoteConstants.YES) {
			_decreaseVote(jsonObject, VoteConstants.YES_DESCRIPTION);
		}
		else if (previousVote == VoteConstants.NOT_VOTED) {
			_decreaseVote(jsonObject, VoteConstants.NOT_VOTED_DESCRIPTION);
		}

		if (vote == VoteConstants.NO) {
			_increaseVote(jsonObject, VoteConstants.NO_DESCRIPTION);
		}
		else if (vote == VoteConstants.YES) {
			_increaseVote(jsonObject, VoteConstants.YES_DESCRIPTION);
		}
		else if (vote == VoteConstants.NOT_VOTED) {
			_increaseVote(jsonObject, VoteConstants.NOT_VOTED_DESCRIPTION);
		}

		return jsonObject.toString();
	}

	private static void _decreaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);

		if (votes > 0) {
			jsonObject.put(vote, --votes);
		}
	}

	private static void _increaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);

		jsonObject.put(vote, ++votes);
	}

	private static void _validateVote(int vote)
		throws NoSuchVoteValueException {

		switch (vote) {
			case VoteConstants.NO:
				break;
			case VoteConstants.YES:
				break;
			case VoteConstants.NOT_VOTED:
				break;
			default :
				throw new NoSuchVoteValueException();
		}
	}

}