(ns project.api
  (:require [castra.core :refer [defrpc *session*]]))

(defrpc get-state []
  (swap! *session* update-in [:id] #(or % (rand-int 100)))
  {:random (rand-int 100)
   :session (:id @*session*)
   :default-text "This is the text text..."
   :amount-of-elements ["text 1" "text 2" "text-3"]})

