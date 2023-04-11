<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210301152557 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE event ADD id_admin_id INT NOT NULL');
        $this->addSql('ALTER TABLE event ADD CONSTRAINT FK_3BAE0AA734F06E85 FOREIGN KEY (id_admin_id) REFERENCES `admin` (id)');
        $this->addSql('CREATE INDEX IDX_3BAE0AA734F06E85 ON event (id_admin_id)');
        $this->addSql('ALTER TABLE product ADD id_admin_id INT NOT NULL');
        $this->addSql('ALTER TABLE product ADD CONSTRAINT FK_D34A04AD34F06E85 FOREIGN KEY (id_admin_id) REFERENCES `admin` (id)');
        $this->addSql('CREATE INDEX IDX_D34A04AD34F06E85 ON product (id_admin_id)');
        $this->addSql('ALTER TABLE reservation_event ADD id_admin_id INT NOT NULL, ADD id_client_id INT NOT NULL');
        $this->addSql('ALTER TABLE reservation_event ADD CONSTRAINT FK_78D1DA0034F06E85 FOREIGN KEY (id_admin_id) REFERENCES `admin` (id)');
        $this->addSql('ALTER TABLE reservation_event ADD CONSTRAINT FK_78D1DA0099DED506 FOREIGN KEY (id_client_id) REFERENCES user (id)');
        $this->addSql('CREATE INDEX IDX_78D1DA0034F06E85 ON reservation_event (id_admin_id)');
        $this->addSql('CREATE INDEX IDX_78D1DA0099DED506 ON reservation_event (id_client_id)');
        $this->addSql('ALTER TABLE reservation_product ADD idadmin_id INT NOT NULL, ADD idclient_id INT NOT NULL');
        $this->addSql('ALTER TABLE reservation_product ADD CONSTRAINT FK_B4DFBF28CEFECA1D FOREIGN KEY (idadmin_id) REFERENCES `admin` (id)');
        $this->addSql('ALTER TABLE reservation_product ADD CONSTRAINT FK_B4DFBF2867F0C0D4 FOREIGN KEY (idclient_id) REFERENCES user (id)');
        $this->addSql('CREATE INDEX IDX_B4DFBF28CEFECA1D ON reservation_product (idadmin_id)');
        $this->addSql('CREATE INDEX IDX_B4DFBF2867F0C0D4 ON reservation_product (idclient_id)');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE event DROP FOREIGN KEY FK_3BAE0AA734F06E85');
        $this->addSql('DROP INDEX IDX_3BAE0AA734F06E85 ON event');
        $this->addSql('ALTER TABLE event DROP id_admin_id');
        $this->addSql('ALTER TABLE product DROP FOREIGN KEY FK_D34A04AD34F06E85');
        $this->addSql('DROP INDEX IDX_D34A04AD34F06E85 ON product');
        $this->addSql('ALTER TABLE product DROP id_admin_id');
        $this->addSql('ALTER TABLE reservation_event DROP FOREIGN KEY FK_78D1DA0034F06E85');
        $this->addSql('ALTER TABLE reservation_event DROP FOREIGN KEY FK_78D1DA0099DED506');
        $this->addSql('DROP INDEX IDX_78D1DA0034F06E85 ON reservation_event');
        $this->addSql('DROP INDEX IDX_78D1DA0099DED506 ON reservation_event');
        $this->addSql('ALTER TABLE reservation_event DROP id_admin_id, DROP id_client_id');
        $this->addSql('ALTER TABLE reservation_product DROP FOREIGN KEY FK_B4DFBF28CEFECA1D');
        $this->addSql('ALTER TABLE reservation_product DROP FOREIGN KEY FK_B4DFBF2867F0C0D4');
        $this->addSql('DROP INDEX IDX_B4DFBF28CEFECA1D ON reservation_product');
        $this->addSql('DROP INDEX IDX_B4DFBF2867F0C0D4 ON reservation_product');
        $this->addSql('ALTER TABLE reservation_product DROP idadmin_id, DROP idclient_id');
    }
}
