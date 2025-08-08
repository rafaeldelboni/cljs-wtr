(ns cljs-wtr.app.wtr
  "Documentation:
   https://modern-web.dev/docs/test-runner/test-frameworks/write-your-own/
   Reference:
   https://github.com/modernweb-dev/web/blob/master/packages/test-runner-mocha/src/standalone.ts"
  (:require
   ["@web/test-runner-core/browser/session.js" :refer [sessionFailed
                                                       sessionFinished
                                                       sessionStarted]]
   [cljs-wtr.app.core-test]
   [clojure.test :as test]))

(defmethod test/report [::test/default :end-run-tests] [m]
  (println :end-run-tests m)
  (if (test/successful? m)
    (js/setTimeout #(sessionFinished (clj->js {:passed true :errors []})))
    (sessionFailed #js {:message "Fail"})))

(defn main []
  (-> (sessionStarted)
      (.then (fn [_] (test/run-all-tests #".*-test$")))))
