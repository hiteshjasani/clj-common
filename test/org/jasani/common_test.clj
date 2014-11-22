(ns org.jasani.common-test
  (:require [clojure.test :refer :all]
            [org.jasani.common :refer :all]))

(deftest simple-test
  (is (= "hello world" (with-out-str (pff "hello %s" "world")))))

(deftest newline-test
  (is (= "hello world\n" (with-out-str (pff "hello %s\n" "world")))))

(deftest retry-succeeds
  (is (= "hello world\n" (with-out-str (with-retries 3 (fn [] (println "hello world")))))))

(deftest retry-fails
  (try
    (with-retries 3 #(throw (Exception. "foo")))
    (catch Exception e
      (is (= "foo" (.getMessage e))))))



