(ns org.jasani.common-test
  (:require [clojure.test :refer :all]
            [org.jasani.common :refer :all]))

(deftest simple-test
  (is (= "hello world" (with-out-str (pff "hello %s" "world")))))

(deftest newline-test
  (is (= "hello world\n" (with-out-str (pff "hello %s\n" "world")))))

