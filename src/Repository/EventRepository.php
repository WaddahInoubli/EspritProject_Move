<?php

namespace App\Repository;

use App\Entity\Event;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Event>
 *
 * @method Event|null find($id, $lockMode = null, $lockVersion = null)
 * @method Event|null findOneBy(array $criteria, array $orderBy = null)
 * @method Event[]    findAll()
 * @method Event[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EventRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Event::class);
    }

    public function save(Event $entity, bool $flush = false): void
    {
        $this->getEntityManager()->persist($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }

    public function remove(Event $entity, bool $flush = false): void
    {
        $this->getEntityManager()->remove($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }
    public function findEventbyname($name)
    {
        return $this->createQueryBuilder('event')
            ->where('event.nom LIKE :sujet OR event.description LIKE :sujet')
            ->setParameter('sujet','%'.$name.'%')
            ->getQuery()
            ->getResult();
    }

    public function trie_decroissant_nom()
    {
        return $this->createQueryBuilder('event')
            ->orderBy('event.nom','DESC')
            ->getQuery()
            ->getResult();
    }
    public function trie_decroissant_date()
    {
        return $this->createQueryBuilder('event')
            ->orderBy('event.datedeb','DESC')
            ->getQuery()
            ->getResult();
    }

    public function trie_decroissant_dateF()
    {
        return $this->createQueryBuilder('event')
            ->orderBy('event.datefin','DESC')
            ->getQuery()
            ->getResult();
    }

//    /**
//     * @return Event[] Returns an array of Event objects
//     */
//    public function findByExampleField($value): array
//    {
//        return $this->createQueryBuilder('e')
//            ->andWhere('e.exampleField = :val')
//            ->setParameter('val', $value)
//            ->orderBy('e.id', 'ASC')
//            ->setMaxResults(10)
//            ->getQuery()
//            ->getResult()
//        ;
//    }

//    public function findOneBySomeField($value): ?Event
//    {
//        return $this->createQueryBuilder('e')
//            ->andWhere('e.exampleField = :val')
//            ->setParameter('val', $value)
//            ->getQuery()
//            ->getOneOrNullResult()
//        ;
//    }
}
