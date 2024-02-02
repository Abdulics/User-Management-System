package com.dultek.ums.exception;

public class MyExceptions {
   public static class UmsException extends RuntimeException {
        public UmsException(String message) {
            super(message);
        }
    }

    public static class AddressNotFoundException extends UmsException {
        public AddressNotFoundException(String message) {
            super(message);
        }
    }

    public static class UserRoleNotFoundException extends UmsException {
        public UserRoleNotFoundException(String message) {
            super(message);
        }
    }

    public static class UserCredentialsNotFoundException extends UmsException {
        public UserCredentialsNotFoundException(String message) {
            super(message);
        }
    }
}

