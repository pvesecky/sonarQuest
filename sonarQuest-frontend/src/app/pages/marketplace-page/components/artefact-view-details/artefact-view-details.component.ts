import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject, OnInit} from '@angular/core';
import {Artefact} from 'app/Interfaces/Artefact';
import {Level} from 'app/Interfaces/Level';
import {Skill} from 'app/Interfaces/Skill';
import {ITdDataTableColumn, ITdDataTableSortChangeEvent, TdDataTableSortingOrder} from '@covalent/core';

@Component({
  selector: 'app-marketplace-artefact-view',
  templateUrl: './artefact-view-details.component.html',
  styleUrls: ['./artefact-view-details.component.css']
})
export class ArtefactViewDetailsComponent implements OnInit {

  icon: any;
  name: string;
  min: number;
  price: number;
  minLevel: Level;
  quantity: number;
  description: string;

  columns: ITdDataTableColumn[] = [
    {name: 'name', label: 'Name', width: {min: 80}},
    {name: 'type', label: 'Type', width: {min: 40}},
    {name: 'value', label: 'Value', width: {min: 40}}
  ];

  // Sort / Filter / Paginate variables
  filteredSkills: Skill[];
  filteredTotal: number;
  searchTerm = '';
  fromRow = 1;
  currentPage = 1;
  pageSize = 5;
  sortBy = 'name';
  selectedRows: any[] = [];
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Ascending;

  constructor(
    private dialogRef: MatDialogRef<ArtefactViewDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public artefact: Artefact) {
    this.artefact = { ...this.artefact };
    this.name = this.artefact.name;
    this.min = this.artefact.minLevel.levelNumber;
    this.price = this.artefact.price;
    this.description = this.artefact.description;
    this.quantity = this.artefact.quantity;
    this.icon = this.artefact.icon;
  }

  ngOnInit() {
  }

  cancel() {
    this.dialogRef.close(false);
  }

  protected createSkillsList(artefact: any) {
    const skillnames = artefact.skills.map(skill => skill.name);
    return skillnames.join(', ');
  }

  sort(sortEvent: ITdDataTableSortChangeEvent): void {
    this.sortBy = sortEvent.name;
    this.sortOrder = sortEvent.order;
  }

}
