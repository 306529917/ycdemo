package com.yc.jee.图书管理.bean;

import java.sql.Date;

public class Book implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String bookname;
	private String bookpress;
	private Date pressdate;
	private String bookauthor;
	private Integer bookcount;
	private String bookimage;
	public Long getBookid() {
		return id;
	}
	public void setBookid(Long id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookpress() {
		return bookpress;
	}
	public void setBookpress(String bookpress) {
		this.bookpress = bookpress;
	}
	public Date getPressdate() {
		return pressdate;
	}
	public void setPressdate(Date pressdate) {
		this.pressdate = pressdate;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public Integer getBookcount() {
		return bookcount;
	}
	public void setBookcount(Integer bookcount) {
		this.bookcount = bookcount;
	}
	public String getBookimage() {
		return bookimage;
	}
	public void setBookimage(String bookimage) {
		this.bookimage = bookimage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", bookpress=" + bookpress + ", pressdate="
				+ pressdate + ", bookauthor=" + bookauthor + ", bookcount=" + bookcount + ", bookimage=" + bookimage
				+ "]";
	}
}
