package com.liferay.micro.maintainance.action;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.api.Action;
import com.liferay.micro.maintainance.util.VoteCalculations;
import com.liferay.micro.maintainance.util.WikiUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.model.WikiPage;

import javax.mail.internet.InternetAddress;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class NotifyCreatorAction implements Action {

	@Override
	public boolean performAction(AnalysisEntry analysisEntry) {
		try {
			WikiPage wikiPage = WikiUtil.getWikiPageByAnalysis(
				analysisEntry.getAnalysisEntryId());

			long companyId = wikiPage.getCompanyId();

			User user = UserLocalServiceUtil.getUser(wikiPage.getUserId());

			User sender = UserLocalServiceUtil.fetchUserByScreenName(
				companyId, "glados");

			if (Validator.isNull(sender)) {
				sender = UserLocalServiceUtil.getDefaultUser(companyId);
			}

			String body = VoteCalculations.toReadableFormat(
				analysisEntry.getAnalysisData());

			_sendMail(
				sender.getEmailAddress(), sender.getFullName(),
				user.getEmailAddress(), _SUBJECT, body);

			return true;
		}
		catch (Exception px) {
		}

		return false;
	}

	private void _sendMail(
			String fromAddress, String fromName, String toAddres,
			String subject, String body)
		throws Exception {

		InternetAddress fromInternetAddress = new InternetAddress(
			fromAddress, fromName);

		MailMessage mailMessage = new MailMessage(
			fromInternetAddress, subject, body, true);

		InternetAddress toInternetAddress = new InternetAddress(toAddres);

		mailMessage.setTo(toInternetAddress);

		MailServiceUtil.sendEmail(mailMessage);
	}

	private static final String _SUBJECT = "Outdated page";

}