package com.hqhan;

/**
 * 〈description〉<br>
 * 〈add bugs to baseline vo〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-14 21:12
 */
public class RemoveBugsParamsVo {

    private String bugId;
    private String removeReason;
    private String removeUser;

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getRemoveUser() {
        return removeUser;
    }

    public void setRemoveUser(String removeUser) {
        this.removeUser = removeUser;
    }
}
