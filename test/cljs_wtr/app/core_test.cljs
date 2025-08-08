(ns cljs-wtr.app.core-test
  (:require
   [clojure.test :refer [async deftest is testing]]))

(deftest dummy-test
  (testing "dummy test should pass"
    (is (= true true))))

(deftest dummy-async-test
  (async done
    (-> (new js/Promise
          ;; not working should be #(resolve true)
          (fn [resolve] (js/setTimeout (resolve true) 100)))
        (.then (fn [result]
                 (is (= true result))
                 (done)))
        (.catch (fn [err]
                  (is (= nil err))
                  (done))))))
