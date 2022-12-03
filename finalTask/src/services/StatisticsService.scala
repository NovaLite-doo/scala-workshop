package services

import models.{Category, Video}

import scala.concurrent.Future

trait StatisticsService {
  def videoWithMostViews: Future[Option[Video]]
  def videoWithLeastViews: Future[Option[Video]]
  def categoryWithMostViews: Future[Option[Category]]
  def categoryWithLeastViews: Future[Option[Category]]
  def channelWithMostViewsForEachCategory: Future[Map[Category, Option[String]]]
}
