package com.hqhan;

/**
 * 〈description〉<br>
 * 〈add bugs to baseline vo〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-02-14 21:12
 */
public class AddBugsParamsVo {

    private String bugId;
    private String addReason;
    private String addUser;

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getAddReason() {
        return addReason;
    }

    public void setAddReason(String addReason) {
        this.addReason = addReason;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }
}
