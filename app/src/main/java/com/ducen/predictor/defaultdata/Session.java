package com.ducen.predictor.defaultdata;

public enum Session {

    PRACTITIONERID {
        public String toString() {
            return "practitionerID";
        }
    },

    EMAIL {
        public String toString() {
            return "email";
        }
    },

    PASSWORD {
        public String toString() {
            return "password";
        }
    },

    IS_LOGIN {
        public String toString() {
            return "logged";
        }
    },

    USERNAME {
        public String toString() {
            return "loggedUser";
        }
    },

    SET_CODE {
        public String toString() {
            return "setCode";
        }
    },
    BASE_SERVER{
        public String toString(){ return "server"; }
    }

}

