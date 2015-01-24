package main

import "fmt"

func main() {
	// type inference
	var a = 1
	var b = "hello"

	fmt.Println(a * 100, b + " world")
}
