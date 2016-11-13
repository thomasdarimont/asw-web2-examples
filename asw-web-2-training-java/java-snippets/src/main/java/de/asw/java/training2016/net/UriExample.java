package de.asw.java.training2016.net;

import java.net.URI;

public class UriExample {
	public static void main(String[] args) {

		URI uri = URI.create("https://user:password@www.example.com:8042/over/there?name=ferret#nose");
		System.out.println(uri);
		System.out.println("Scheme: " + uri.getScheme());
		System.out.println("Scheme-SpecificPart: " + uri.getSchemeSpecificPart());
		System.out.println("Userinfo: " + uri.getUserInfo());
		System.out.println("Host: " + uri.getHost());
		System.out.println("Authority: " + uri.getAuthority());
		System.out.println("Port: " + uri.getPort());
		System.out.println("Path: " + uri.getPath());
		System.out.println("Query: " + uri.getQuery());
		System.out.println("Fragment: " + uri.getFragment());
	}
}
