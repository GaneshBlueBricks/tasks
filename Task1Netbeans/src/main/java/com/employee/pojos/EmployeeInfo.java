package com.employee.pojos;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7872013883717411090L;

	private String name;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private byte[] image;

            public EmployeeInfo(String name, String phone, String email, String address) {
                this.name = name;
                this.phone = phone;
                this.email = email;
                this.address = address;
            }

        public EmployeeInfo(String name, String phone, String email, String address, byte[] image) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.image = image;
        }

            public EmployeeInfo() {
            }

            public static long getSerialVersionUID() {
                return serialVersionUID;
            }

            public String getName() {
                return name;
            }

            public String getPhone() {
                return phone;
            }

            public String getEmail() {
                return email;
            }

            public String getAddress() {
                return address;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setAddress(String address) {
                this.address = address;
            }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
            

    @Override
    public String toString() {
        return "EmployeeInfo{" + "name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", image=" + image+ '}';
    }

           
            


}
