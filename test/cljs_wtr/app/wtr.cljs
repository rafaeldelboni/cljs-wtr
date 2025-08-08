(ns cljs-wtr.app.wtr
  "https://modern-web.dev/docs/test-runner/test-frameworks/write-your-own/"
  (:require
   ["@web/test-runner-core/browser/session.js" :refer [sessionFailed
                                                       sessionFinished
                                                       sessionStarted]]
   [cljs-wtr.app.core-test]
   [clojure.test :as test]))

(defmethod test/report [::test/default :end-run-tests] [m]
  (if (test/successful? m)
    (sessionFinished #js {:passed true})
    (sessionFailed #js {:message "Fail"})))

(defn main []
  (-> (sessionStarted)
      (.then (fn [_]
               (test/run-all-tests #".*-test$")))))
