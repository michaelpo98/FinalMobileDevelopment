package com.example.finalmobiledevelopment;

import java.util.Date;

public class Chat {

        public Chat(){

        }

        public Chat (String text,String user, String tanggal){
            messageText = text;
            messageUser = user;
            messageTime = tanggal;
        }

        private String messageText;
        private String messageUser;
        private String messageTime;

        public String getMessageText() {
            return messageText;
        }

        public void setMessageText(String messageText) {
            this.messageText = messageText;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public void setMessageUser(String messageUser) {
            this.messageUser = messageUser;
        }

        public String getMessageTime() {
            return messageTime;
        }

        public void setMessageTime(String messageTime) {
            this.messageTime = messageTime;
        }
}
